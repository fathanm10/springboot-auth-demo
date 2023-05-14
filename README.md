# Spring Boot Auth Demo

This project is a simple example for configuring authentication in spring boot.

### Authentication Flow:
1. Register user.
2. Login user.
3. SecurityContext principal (identity of authenticated user) will be handled by / mapped to CustomUserDetails and CustomUserDetailsService.
   - Mapped User object is stored in this principal (CustomUserDetails) class.
   - Authorities are based on the Role of User object.
   - Use getter/setter to get values of User object of authenticated user. 
4. Based on authorities, paths available to each authority are handled in SecurityConfig class.
   - Handle login and logout path in aforementioned class too.