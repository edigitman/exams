package ro.ghasachi.bt.web.hateoas.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ro.ghasachi.bt.middleware.EmailService;
import ro.ghasachi.bt.persistence.tables.pojos.User;
import ro.ghasachi.bt.web.hateoas.event.OnRegistrationCompleteEvent;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    @Autowired
    private EmailService emailService;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        emailService.sendRegistrationEmail(event.getUser(), event.getAppUrl());
    }
}
