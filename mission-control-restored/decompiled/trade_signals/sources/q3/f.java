package q3;

import android.util.Base64;
import com.revenuecat.purchases.common.Constants;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public URI f22573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f22576d;

    public f(URI uri, String str, Map map) {
        this.f22575c = null;
        this.f22573a = uri;
        this.f22574b = str;
        this.f22576d = map;
        this.f22575c = a();
    }

    public final String a() {
        byte[] bArr = new byte[16];
        for (int i8 = 0; i8 < 16; i8++) {
            bArr[i8] = (byte) d(0, 255);
        }
        return Base64.encodeToString(bArr, 2);
    }

    public final String b(LinkedHashMap linkedHashMap) {
        String str = new String();
        for (String str2 : linkedHashMap.keySet()) {
            str = str + str2 + ": " + ((String) linkedHashMap.get(str2)) + "\r\n";
        }
        return str;
    }

    public byte[] c() {
        String path = this.f22573a.getPath();
        String query = this.f22573a.getQuery();
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        sb.append(query == null ? "" : "?" + query);
        String string = sb.toString();
        String host = this.f22573a.getHost();
        if (this.f22573a.getPort() != -1) {
            host = host + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f22573a.getPort();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Host", host);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put("Connection", "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", "13");
        linkedHashMap.put("Sec-WebSocket-Key", this.f22575c);
        String str = this.f22574b;
        if (str != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", str);
        }
        Map map = this.f22576d;
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!linkedHashMap.containsKey(str2)) {
                    linkedHashMap.put(str2, (String) this.f22576d.get(str2));
                }
            }
        }
        byte[] bytes = ((("GET " + string + " HTTP/1.1\r\n") + b(linkedHashMap)) + "\r\n").getBytes(Charset.defaultCharset());
        byte[] bArr = new byte[bytes.length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return bArr;
    }

    public final int d(int i8, int i9) {
        return (int) ((Math.random() * ((double) i9)) + ((double) i8));
    }

    public void e(HashMap map) {
        if (!"websocket".equals(map.get("upgrade"))) {
            throw new e("connection failed: missing header field in server handshake: Upgrade");
        }
        if (!"upgrade".equals(map.get("connection"))) {
            throw new e("connection failed: missing header field in server handshake: Connection");
        }
    }

    public void f(String str) {
        int i8 = Integer.parseInt(str.substring(9, 12));
        if (i8 == 407) {
            throw new e("connection failed: proxy authentication not supported");
        }
        if (i8 == 404) {
            throw new e("connection failed: 404 not found");
        }
        if (i8 == 101) {
            return;
        }
        throw new e("connection failed: unknown status code " + i8);
    }
}
