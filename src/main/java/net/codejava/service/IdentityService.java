package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.codejava.model.Identity;
import net.codejava.repository.IdentityRepository;

@Service
@Transactional
public class IdentityService {

    @Autowired
    private IdentityRepository repo;
    
    public List<Identity> listAll() {
		return repo.findAll();
	}

	public void save(Identity identity) {
		repo.save(identity);
	}

	public Identity get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}
}