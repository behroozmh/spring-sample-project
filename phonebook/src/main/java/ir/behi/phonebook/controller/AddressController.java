package ir.behi.phonebook.controller;

import ir.behi.phonebook.dto.AddressDTO;
import ir.behi.phonebook.dto.PersonDTO;
import ir.behi.phonebook.exception.ServiceException;
import ir.behi.phonebook.service.AddressService;
import ir.behi.phonebook.service.PersonService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * create User: behrooz.mh
 * Date: 12/19/2022
 * TIME: 10:19 AM
 **/
@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController( AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Integer id) throws ServiceException {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/getAllByPaging")
    public ResponseEntity getAllByPaging(@RequestParam Pageable pageable) {
        return ResponseEntity.ok(addressService.findAllByPaging((pageable)));
    }

    @GetMapping("/getById")
    public ResponseEntity getById(@RequestParam Integer id) throws ServiceException {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody AddressDTO address) {
        return ResponseEntity.ok(addressService.insert(address));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody AddressDTO address) {
        return ResponseEntity.ok(addressService.update(address));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) throws ServiceException {
        return ResponseEntity.ok(addressService.delete(id));
    }
}
