import com.example.tacofactory.controller.HomeController;
import jakarta.servlet.ServletContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;




@WebMvcTest(controllers = HomeController.class)
public class HomeControllerTest {
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void testHomePage() throws Exception{
           mockMvc.perform(MockMvcRequestBuilders.get("/"))
                   .andExpect(MockMvcResultMatchers.status().isOk())
                   .andExpect(MockMvcResultMatchers.view().name("home"))
                   .andExpect(MockMvcResultMatchers.content().string("Welcome"));
        }
//
//        @Test
//        void testTacoPost() throws Exception{
//                mockMvc.perform(MockMvcRequestBuilders.post("/design",
//                        "taco:{ name" +
//                                "}"))
//        }
}
