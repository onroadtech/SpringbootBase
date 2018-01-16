package tech.onroad.springbootbase.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin").password("123456").roles("USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().disable();
    	http
	        .authorizeRequests()
	            .antMatchers("/", "/register", "/reg").permitAll()
	            .anyRequest().authenticated()
	            .and()
	        .formLogin()
	            .loginPage("/login")
	            .failureUrl("/login?error")
	            .defaultSuccessUrl("/welcome")
	            .permitAll()
	            .and()
	        .logout()
	            .permitAll();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/css/**");
    }
}
