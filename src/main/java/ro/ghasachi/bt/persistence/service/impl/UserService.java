package ro.ghasachi.bt.persistence.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.dao.IUserDao;
import ro.ghasachi.bt.persistence.model.EUser;
import ro.ghasachi.bt.persistence.service.IUserService;
import ro.ghasachi.bt.persistence.service.common.AbstractService;
import ro.ghasachi.bt.web.vo.UserVO;

/**
 * Created by edi on 12/19/2015.
 */
@Service
@Transactional
public class UserService extends AbstractService<EUser> implements IUserService {

	@Autowired
	private IUserDao dao;

	public UserService() {
		super();
	}

	@Override
	protected PagingAndSortingRepository<EUser, Long> getDao() {
		return dao;
	}

	@Override
	public EUser retrieveByEmail(String email) {
		return dao.retrieveByEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public EUser create(EUser entity) {
		return super.create(entity);
	}

	@Override
	@Transactional(readOnly = true)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public EUser update(EUser entity) {
		return super.update(entity);
	}

	@Override
	@Transactional(readOnly = true)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(EUser entity) {
		super.delete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteById(long entityId) {
		super.deleteById(entityId);
	}	
}
