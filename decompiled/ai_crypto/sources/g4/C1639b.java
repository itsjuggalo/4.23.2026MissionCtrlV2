package g4;

import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: renamed from: g4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1639b implements InterfaceC1638a {
    @Override // g4.InterfaceC1638a
    public HttpURLConnection a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }
}
