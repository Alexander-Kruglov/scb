package scb.backend.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import scb.backend.dto.DeliveryDto;
import scb.backend.service.DeliveryService;

import java.util.List;

@RestController
public class DeliveryController {

    private final DeliveryService service;

    public DeliveryController(DeliveryService service) {
        this.service = service;
    }

    @GetMapping("/deliveries")
    public ResponseEntity<List<DeliveryDto>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findAll());
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @PostMapping("/deliveries")
    public ResponseEntity<DeliveryDto> saveDelivery(@Valid @RequestBody  DeliveryDto dto, Authentication authentication) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(dto, authentication.getName()));
    }

    @GetMapping("/deliveries/{id}")
    public ResponseEntity<DeliveryDto> getById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @PutMapping("/deliveries/{id}")
    public ResponseEntity<DeliveryDto> updateDelivery(@Valid @RequestBody  DeliveryDto dto, @PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.update(dto, id));
    }

    @PreAuthorize("hasRole('MANAGER')")
    @DeleteMapping("/deliveries/{id}")
    public void deleteDelivery(@PathVariable Long id) {
        service.deleteById(id);
    }
}
