package Z0;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    public static n a(List list) {
        return new d(list);
    }

    public static DataEncoder b() {
        return new JsonDataEncoderBuilder().configureWith(b.f5768a).ignoreNullValues(true).build();
    }

    public abstract List c();
}
