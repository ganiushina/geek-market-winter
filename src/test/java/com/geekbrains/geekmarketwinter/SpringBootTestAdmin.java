package com.geekbrains.geekmarketwinter;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootTestAdmin {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void mytest1() throws Exception {
        mockMvc.perform(get("/shop"))
                .andExpect(status().isOk());
    }

    @Test
    public void mytest2() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }


    @Test
    public void badCredentials() throws Exception {
        mockMvc.perform(formLogin("/authenticateTheUser").user("admkkin").password("100"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?error"));
    }

    @Test
    public void testHomePage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andDo(print());
    }


    @Test
    public void badCredentialsToProductAddPage() throws Exception {
        this.mockMvc.perform( get("/shop/edit/{id}", 0))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void isUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin")
                .with(SecurityRequestPostProcessors.userDeatilsService("admin")))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addProduct() throws Exception {
        mockMvc.perform(formLogin("/shop/edit/0").user("admin").password("100"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/shop/edit/0"));
    }

}
