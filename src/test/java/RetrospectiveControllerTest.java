import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.java.interview.sprint.controller.RetrospectiveController;
import com.java.interview.sprint.model.Retrospective;
import com.java.interview.sprint.service.RetrospectiveService;


@RunWith(MockitoJUnitRunner.Silent.class)
public class RetrospectiveControllerTest {
	private MockMvc mockMvc;

	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	@Mock
	private RetrospectiveService retrospectiveService;
	
	@InjectMocks
	private RetrospectiveController retrospectiveController;
	
	
	@Before
	public void setUp() {
		
		
		  MockitoAnnotations.initMocks(this); 
		  this.mockMvc= MockMvcBuilders.standaloneSetup(retrospectiveController).build();
		 
	}
	
	
	@Test
	public void getAllRecordsTest() throws Exception {
		
		String[] participant={"Rahul", "Utkarsh", "Shubham", "Neelam"};
		Retrospective retro1= new Retrospective();
		retro1.setRetrospectiveId(1L);
		retro1.setName("Retro1");
		retro1.setSummary("Post release");
		retro1.setDate(new Date(1984-12-17));
		retro1.setParticipants(Arrays.asList(participant));
		
		Retrospective retro2= new Retrospective();
		retro2.setRetrospectiveId(2L);
		retro2.setName("Retro2");
		retro2.setSummary("Post release2");
		retro2.setDate(new Date(1984-12-11));
		retro2.setParticipants(Arrays.asList(participant));
		
		Retrospective retro3= new Retrospective();
	    retro3.setRetrospectiveId(3L);
		retro3.setName("Retro3");
		retro3.setSummary("Post release3");
		retro3.setDate(new Date(1984-12-30));
		retro3.setParticipants(Arrays.asList(participant));
		List<Retrospective> records= new ArrayList<Retrospective>();
		records.add(retro1);
		records.add(retro2);
		records.add(retro3	);
		
		
		Mockito.when(retrospectiveService.getAllRetrospective()).thenReturn(records);
			 mockMvc.perform(MockMvcRequestBuilders.get("/retrospective").
			 contentType(MediaType.APPLICATION_JSON))
			 .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
			 .andExpect(MockMvcResultMatchers.jsonPath("$[2].name",is("Retro3")));
			 
	}
	
	
	@Test
    public void createRetrospectiveTest() throws Exception {
		
		String[] participant={"Rahul", "Utkarsh", "Shubham", "Neelam"};
		Retrospective retro5= new Retrospective();
		retro5.setName("Retro1");
		retro5.setSummary("Post release1111");
		retro5.setDate(new Date(1984-12-17));
		retro5.setParticipants(Arrays.asList(participant));
		
		Mockito.when(retrospectiveService.createRetrospective(retro5)).thenReturn(retro5);
		 
		
        mockMvc.perform(MockMvcRequestBuilders.post("/retrospective").contentType(MediaType.APPLICATION_JSON).content(asJsonString(retro5)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

       
    }
	
	@Test
    public void createRetrospectiveNegativeTest() throws Exception {
		
		
		Retrospective retro1= null;
	        mockMvc.perform(MockMvcRequestBuilders.post("/retrospective").contentType(MediaType.APPLICATION_JSON).content(asJsonString(retro1)))
                .andExpect(MockMvcResultMatchers.status().is(400));

       
    }
	
	@Test
    public void updateRetrospectiveTest() throws Exception {
		
		String[] participant={"Rahul", "Utkarsh", "Shubham", "Neelam"};
		Retrospective retro1= new Retrospective();
		retro1.setRetrospectiveId(1L);
		retro1.setName("Retro1");
		retro1.setSummary("Post release1111");
		retro1.setDate(new Date(1984-12-17));
		retro1.setParticipants(Arrays.asList(participant));
		
		 Mockito.when(retrospectiveService.createRetrospective(retro1)).thenReturn(retro1);
		 
		 mockMvc.perform(MockMvcRequestBuilders.put("/retrospective").contentType(MediaType.APPLICATION_JSON).content(asJsonString(retro1)))
                .andExpect(MockMvcResultMatchers.status().isOk());
            

       
    }
	
	@Test
    public void updateRetrospectiveNegativeTest() throws Exception {
		
		
		Retrospective retro1= null;
	        mockMvc.perform(MockMvcRequestBuilders.put("/retrospective").contentType(MediaType.APPLICATION_JSON).content(asJsonString(retro1)))
                .andExpect(MockMvcResultMatchers.status().is(400));

       
    }
	
	 public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	
}
