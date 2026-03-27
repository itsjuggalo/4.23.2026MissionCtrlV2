package t;

import android.app.Person;
import android.graphics.drawable.Icon;
import androidx.core.graphics.drawable.IconCompat;
import x.AbstractC1394b;

/* JADX INFO: loaded from: classes.dex */
public abstract class X {
    public static Y a(Person person) {
        CharSequence name = person.getName();
        IconCompat iconCompatB = person.getIcon() != null ? IconCompat.b(person.getIcon()) : null;
        String uri = person.getUri();
        String key = person.getKey();
        boolean zIsBot = person.isBot();
        boolean zIsImportant = person.isImportant();
        Y y = new Y();
        y.f9801a = name;
        y.f9802b = iconCompatB;
        y.f9803c = uri;
        y.f9804d = key;
        y.e = zIsBot;
        y.f9805f = zIsImportant;
        return y;
    }

    public static Person b(Y y) {
        Person.Builder name = new Person.Builder().setName(y.f9801a);
        Icon iconF = null;
        IconCompat iconCompat = y.f9802b;
        if (iconCompat != null) {
            iconCompat.getClass();
            iconF = AbstractC1394b.f(iconCompat, null);
        }
        return name.setIcon(iconF).setUri(y.f9803c).setKey(y.f9804d).setBot(y.e).setImportant(y.f9805f).build();
    }
}
