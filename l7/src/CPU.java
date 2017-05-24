/**
 * Created by Dan on 24-May-17.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CPU {



    public static String getInfo(){
        String ret = "";
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getName().startsWith("get")
                    && Modifier.isPublic(method.getModifiers())) {
                Object value;
                try {
                    value = method.invoke(operatingSystemMXBean);
                } catch (Exception e) {
                    value = e;
                } // try
                //System.out.println(method.getName() + " = " + value);
                ret = ret + ("\n" + method.getName() + " = " + value);
            } // if
        } // for
        return ret;

    }

    public static void main(String[] args) throws AWTException, IOException {
        //System.out.println(getInfo());


    }


}
