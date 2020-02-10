package org.arun.springoauth.rest;

import java.util.Set;
import org.arun.springoauth.config.SecurityContextUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/employees")
public class EmployeeRestController {

  @CrossOrigin
  @GetMapping(path = "/username")
  @PreAuthorize("hasAnyAuthority('ROLE_USER')")
  public String getAuthorizedUserName() {
    return "Hello" +SecurityContextUtils.getUserName();
  }

  @GetMapping(path = "/roles")
  @PreAuthorize("hasAnyAuthority('ROLE_USER')")
  public ResponseEntity<Set<String>> getAuthorizedUserRoles() {
    return ResponseEntity.ok(SecurityContextUtils.getUserRoles());
  }
}
