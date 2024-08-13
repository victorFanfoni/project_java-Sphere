package br.com.fiap.apisphere.user;

import br.com.fiap.apisphere.user.dto.UserFormRequest;
import br.com.fiap.apisphere.user.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public List<UserResponse> findAll() {
        return service
                .findAll()
                .stream()
                .map(UserResponse::feromModel)
                .toList();
    }

    @PostMapping
    public ResponseEntity<UserResponse> crate(@RequestBody UserFormRequest userForm, UriComponentsBuilder builder) {
        var user = service.create(userForm.toModel());

        var uri = builder
                .path("/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(UserResponse.feromModel(user));
    }
}
