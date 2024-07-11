package org.example.services;


import io.jsonwebtoken.Jwts;
import org.example.daos.AuthDao;
import org.example.exceptions.Entity;
import org.example.exceptions.InvalidException;
import org.example.models.LoginRequest;
import org.example.models.User;

import java.sql.Date;
import java.sql.SQLException;

public class AuthService {

    private AuthDao authDao;

    public AuthService(AuthDao authDao){
        this.authDao = authDao;
    }

    public String login (LoginRequest loginRequest) throws SQLException, InvalidException {

        User user = authDao.getUser(loginRequest);

        if (user == null){
            throw new InvalidException(Entity.USER, "Invalid credentials");
        }
        return generateJwtToken(user);

    }

    private String generateJwtToken(User user){
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 28800000))
                .claim("Role", user.getSystemRoleId())
                .subject(user.getUsername())
                .issuer("DropwizardDemo")
                .signWith(Jwts.SIG.HS256.key().build())
                .compact();

    }


}