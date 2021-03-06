package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * xml설정
 * <bean class="polymorphism.LgTv"></bean>
 */
@Component("tv")
public class LgTV implements TV {
    @Autowired
    private Speaker speaker;

    @Override
    public void powerOn() {
        System.out.println("LgTV---전원 켠다.");
    }

    @Override
    public void powerOff() {
        System.out.println("LgTV---전원 끈다.");
    }

    @Override
    public void volumeUp() {
        speaker.volumeUp();
    }

    @Override
    public void volumeDown() {
        speaker.volumeDown();
    }
}
