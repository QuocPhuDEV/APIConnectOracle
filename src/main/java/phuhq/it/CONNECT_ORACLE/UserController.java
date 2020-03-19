package phuhq.it.CONNECT_ORACLE;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/users" })
public class UserController {

	private UserRepository repository;

	UserController(UserRepository repository) {
		this.repository = repository;
	}
	

	// Get all user in table
	@GetMapping
	public List<User> findAll() {
		return repository.findAll();
	}

	// Get only user with ID
	@GetMapping(path = { "/{id}" })
	public ResponseEntity<User> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	// Add new User
	@PostMapping
	public User create(@RequestBody User user) {
		return repository.save(user);
	}

	// Update user
	@PutMapping(value = "/{id}")

	public ResponseEntity<User> update(@PathVariable("id") long id, @RequestBody User user) {
		return repository.findById(id).map(record -> {
			record.setUserName(user.getUserName());
			record.setFullName(user.getFullName());
			record.setPassWord(user.getPassWord());
			User updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());

	}

	// Delete User
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());

	}

}
