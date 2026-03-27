package n5;

import Q4.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import n5.AbstractC2268c;

/* JADX INFO: renamed from: n5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2266a implements Q4.a, AbstractC2268c.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f19858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final G f19859d;

    /* JADX INFO: renamed from: n5.a$a, reason: collision with other inner class name */
    public static class C0326a implements G {
        @Override // n5.G
        public String a(List list) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(list);
                objectOutputStream.flush();
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (IOException e7) {
                throw new RuntimeException(e7);
            }
        }

        @Override // n5.G
        public List b(String str) {
            try {
                return (List) new L(new ByteArrayInputStream(Base64.decode(str, 0))).readObject();
            } catch (IOException | ClassNotFoundException e7) {
                throw new RuntimeException(e7);
            }
        }
    }

    public C2266a() {
        this(new C0326a());
    }

    private void E(V4.b bVar, Context context) {
        this.f19858c = context.getSharedPreferences("FlutterSharedPreferences", 0);
        try {
            AbstractC2268c.b.b(bVar, this);
        } catch (Exception e7) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesPlugin", e7);
        }
    }

    public final Map D(String str, Set set) {
        Map<String, ?> all = this.f19858c.getAll();
        HashMap map = new HashMap();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (set == null || set.contains(str2))) {
                Object obj = all.get(str2);
                Objects.requireNonNull(obj);
                map.put(str2, F(str2, obj));
            }
        }
        return map;
    }

    public final Object F(String str, Object obj) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
                return str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!") ? obj : this.f19859d.b(str2.substring(40));
            }
            if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy")) {
                return new BigInteger(str2.substring(44), 36);
            }
            if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
                return Double.valueOf(str2.substring(40));
            }
        } else if (obj instanceof Set) {
            ArrayList arrayList = new ArrayList((Set) obj);
            this.f19858c.edit().remove(str).putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + this.f19859d.a(arrayList)).apply();
            return arrayList;
        }
        return obj;
    }

    @Override // n5.AbstractC2268c.b
    public Map d(String str, List list) {
        return D(str, list == null ? null : new HashSet(list));
    }

    @Override // n5.AbstractC2268c.b
    public Boolean g(String str, List list) {
        SharedPreferences.Editor editorEdit = this.f19858c.edit();
        Map<String, ?> all = this.f19858c.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (list == null || list.contains(str2))) {
                arrayList.add(str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        return Boolean.valueOf(editorEdit.commit());
    }

    @Override // n5.AbstractC2268c.b
    public Boolean o(String str, Long l7) {
        return Boolean.valueOf(this.f19858c.edit().putLong(str, l7.longValue()).commit());
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b bVar) {
        E(bVar.b(), bVar.a());
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b bVar) {
        AbstractC2268c.b.b(bVar.b(), null);
    }

    @Override // n5.AbstractC2268c.b
    public Boolean r(String str, String str2) {
        if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu") || str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy") || str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
            throw new RuntimeException("StorageError: This string cannot be stored as it clashes with special identifier prefixes");
        }
        return Boolean.valueOf(this.f19858c.edit().putString(str, str2).commit());
    }

    @Override // n5.AbstractC2268c.b
    public Boolean remove(String str) {
        return Boolean.valueOf(this.f19858c.edit().remove(str).commit());
    }

    @Override // n5.AbstractC2268c.b
    public Boolean s(String str, String str2) {
        return Boolean.valueOf(this.f19858c.edit().putString(str, str2).commit());
    }

    @Override // n5.AbstractC2268c.b
    public Boolean t(String str, List list) {
        return Boolean.valueOf(this.f19858c.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + this.f19859d.a(list)).commit());
    }

    @Override // n5.AbstractC2268c.b
    public Boolean w(String str, Boolean bool) {
        return Boolean.valueOf(this.f19858c.edit().putBoolean(str, bool.booleanValue()).commit());
    }

    @Override // n5.AbstractC2268c.b
    public Boolean x(String str, Double d7) {
        String string = Double.toString(d7.doubleValue());
        return Boolean.valueOf(this.f19858c.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit());
    }

    public C2266a(G g7) {
        this.f19859d = g7;
    }
}
