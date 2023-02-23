import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import pl.pwc.deliveryhubbackend.messeges.ResponseMessage;
import pl.pwc.deliveryhubbackend.services.ExcelDocumentStorageService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExcelDocumentControllerTest {

    @Mock
    private ExcelDocumentStorageService storageService;

    @Mock
    private MultipartFile file;

    @Test
    public void testUploadFile() {
        // Arrange
        String filename = "example.xlsx";
        when(file.getOriginalFilename()).thenReturn(filename);
        when(storageService.store(any(MultipartFile.class))).thenReturn(filename);

        ExcelDocumentController controller = new ExcelDocumentController();
        controller.excelDocumentStorageService = storageService;

        // Act
        ResponseEntity<ResponseMessage> response = controller.uploadFile(file);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Uploaded the file successfully: " + filename, response.getBody().getMessage());
    }
}
