package ro.ghasachi.bt.middleware;

import ro.ghasachi.bt.persistence.tables.pojos.User;

/**
 * Created by d-uu31cq on 31/12/2015.
 */
public interface EmailService {

    void sendRegistrationEmail(User user, String appUrl);

}
