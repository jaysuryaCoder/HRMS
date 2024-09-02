//package com.fdaindia.hrms.tokenconfig;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//import org.springframework.stereotype.Component;
////
////import com.example.demo.entity.FDAIndiaCard;
////import com.example.demo.entity.FDAIndiaKendra;
//
//import com.fdaindia.hrms.entity.FdaEmployee;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.MalformedJwtException;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.SignatureException;
//import io.jsonwebtoken.UnsupportedJwtException;
//
//@Component
//public class JwtTokenUtil implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//
//    private String secret = "secKey";
//
//    public String getUserNameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    public Date getIssuedAtDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getIssuedAt);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//    }
//
//    private Boolean isTokenExpired(String token) {
//        try {
//            final Date expiration = getClaimFromToken(token, Claims::getExpiration);
//            return expiration.before(new Date());
//        } catch (ExpiredJwtException expiredJwtException) {
//            return true;
//        }
//    }
//
//    private Boolean isTokenValid(String token, int type) {
//        try {
//            String usrType = getClaimFromToken(token, Claims::getAudience);
//            if (type == 1 && usrType.equalsIgnoreCase("User")) {
//                return true;
//            } else if (type == 2 && usrType.equalsIgnoreCase("Kendra")) {
//                return true;
//            }
//            else if (type == 3 && usrType.equalsIgnoreCase("Hrms")) {
//                return true;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//        return false;
//    }
//
//    private Boolean ignoreTokenExpiration(String token) {
//        return false;
//    }
//
//
//    public String generateToken(FdaEmployee fdaEmployee) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("sub", fdaEmployee.getUsername());
//        claims.put("aud", "Hrms");
//
//        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//                .signWith(SignatureAlgorithm.HS512, secret).compact();
//    }
//    public String generateToken(String username) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("sub", username);
//        claims.put("aud", "Hrms");
//
//        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//                .signWith(SignatureAlgorithm.HS512, secret).compact();
//    }
//
//
//
//    public String generateTokenWithSessionId(FdaEmployee fdaEmployee, String sessionId, Date sessionExpiry) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("sub", fdaEmployee.getUsername());
//        claims.put("aud", "Hrms");
//        claims.put("sessionId", sessionId);
//        claims.put("role", fdaEmployee.getRole()); // Ensure the role is set in the claims
//
//        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(sessionExpiry)
//                .signWith(SignatureAlgorithm.HS512, secret).compact();
//    }
//
//    public Boolean canTokenBeRefreshed(String token) {
//        return (isTokenExpired(token) || ignoreTokenExpiration(token));
//    }
//
//    public Boolean validateToken(String token, int type) {
//        try {
//            if (!isTokenExpired(token)) {
//                return isTokenValid(token, type);
//            }
//            return false;
//        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException
//                | IllegalArgumentException ex) {
//            if (ex instanceof SignatureException) {
//                throw new SignatureException("Invalid JWT-Token signature!");
//            } else if (ex instanceof MalformedJwtException) {
//                throw new MalformedJwtException("Jwt-token Structure is invalid");
//            } else if (ex instanceof ExpiredJwtException) {
//                throw new ExpiredJwtException(null, null, "jwt-token has expired, Please try to login with new token");
//            } else if (ex instanceof UnsupportedJwtException) {
//                throw new UnsupportedJwtException("Unsupported Jwt-token format");
//            } else if (ex instanceof IllegalArgumentException) {
//                throw new IllegalArgumentException("Invalid argument found when processing the Jwt-token");
//            }
//
//            throw ex;
//        }
//    }
//}
