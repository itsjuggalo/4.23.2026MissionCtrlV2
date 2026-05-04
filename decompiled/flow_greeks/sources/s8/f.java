package s8;

import android.util.Base64;
import com.revenuecat.purchases.common.Constants;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public URI f20090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f20093d;

    public f(URI uri, String str, Map map) {
        this.f20092c = null;
        this.f20090a = uri;
        this.f20091b = str;
        this.f20093d = map;
        this.f20092c = a();
    }

    public final String a() {
        byte[] bArr = new byte[16];
        for (int i10 = 0; i10 < 16; i10++) {
            bArr[i10] = (byte) d(0, 255);
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
        String path = this.f20090a.getPath();
        String query = this.f20090a.getQuery();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(path);
        sb2.append(query == null ? "" : "?" + query);
        String string = sb2.toString();
        String host = this.f20090a.getHost();
        if (this.f20090a.getPort() != -1) {
            host = host + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f20090a.getPort();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Host", host);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put("Connection", "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", "13");
        linkedHashMap.put("Sec-WebSocket-Key", this.f20092c);
        String str = this.f20091b;
        if (str != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", str);
        }
        Map map = this.f20093d;
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!linkedHashMap.containsKey(str2)) {
                    linkedHashMap.put(str2, (String) this.f20093d.get(str2));
                }
            }
        }
        byte[] bytes = ((("GET " + string + " HTTP/1.1\r\n") + b(linkedHashMap)) + "\r\n").getBytes(Charset.defaultCharset());
        byte[] bArr = new byte[bytes.length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return bArr;
    }

    public final int d(int i10, int i11) {
        return (int) ((Math.random() * ((double) i11)) + ((double) i10));
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
        int i10 = Integer.parseInt(str.substring(9, 12));
        if (i10 == 407) {
            throw new e("connection failed: proxy authentication not supported");
        }
        if (i10 == 404) {
            throw new e("connection failed: 404 not found");
        }
        if (i10 == 101) {
            return;
        }
        throw new e("connection failed: unknown status code " + i10);
    }
}
