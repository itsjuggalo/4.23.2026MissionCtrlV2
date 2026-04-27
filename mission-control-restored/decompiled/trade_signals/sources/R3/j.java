package R3;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class j extends i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f7167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f7168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f7169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final R3.a f7170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f7171i;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f7172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public n f7173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f7174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public R3.a f7175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f7176e;

        public j a(e eVar, Map map) {
            if (this.f7172a == null) {
                throw new IllegalArgumentException("Modal model must have a title");
            }
            R3.a aVar = this.f7175d;
            if (aVar != null && aVar.c() == null) {
                throw new IllegalArgumentException("Modal model action must be null or have a button");
            }
            if (TextUtils.isEmpty(this.f7176e)) {
                throw new IllegalArgumentException("Modal model must have a background color");
            }
            return new j(eVar, this.f7172a, this.f7173b, this.f7174c, this.f7175d, this.f7176e, map);
        }

        public b b(R3.a aVar) {
            this.f7175d = aVar;
            return this;
        }

        public b c(String str) {
            this.f7176e = str;
            return this;
        }

        public b d(n nVar) {
            this.f7173b = nVar;
            return this;
        }

        public b e(g gVar) {
            this.f7174c = gVar;
            return this;
        }

        public b f(n nVar) {
            this.f7172a = nVar;
            return this;
        }
    }

    public j(e eVar, n nVar, n nVar2, g gVar, R3.a aVar, String str, Map map) {
        super(eVar, MessageType.MODAL, map);
        this.f7167e = nVar;
        this.f7168f = nVar2;
        this.f7169g = gVar;
        this.f7170h = aVar;
        this.f7171i = str;
    }

    public static b d() {
        return new b();
    }

    @Override // R3.i
    public g b() {
        return this.f7169g;
    }

    public R3.a e() {
        return this.f7170h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (hashCode() != jVar.hashCode()) {
            return false;
        }
        n nVar = this.f7168f;
        if ((nVar == null && jVar.f7168f != null) || (nVar != null && !nVar.equals(jVar.f7168f))) {
            return false;
        }
        R3.a aVar = this.f7170h;
        if ((aVar == null && jVar.f7170h != null) || (aVar != null && !aVar.equals(jVar.f7170h))) {
            return false;
        }
        g gVar = this.f7169g;
        return (gVar != null || jVar.f7169g == null) && (gVar == null || gVar.equals(jVar.f7169g)) && this.f7167e.equals(jVar.f7167e) && this.f7171i.equals(jVar.f7171i);
    }

    public String f() {
        return this.f7171i;
    }

    public n g() {
        return this.f7168f;
    }

    public n h() {
        return this.f7167e;
    }

    public int hashCode() {
        n nVar = this.f7168f;
        int iHashCode = nVar != null ? nVar.hashCode() : 0;
        R3.a aVar = this.f7170h;
        int iHashCode2 = aVar != null ? aVar.hashCode() : 0;
        g gVar = this.f7169g;
        return this.f7167e.hashCode() + iHashCode + this.f7171i.hashCode() + iHashCode2 + (gVar != null ? gVar.hashCode() : 0);
    }
}
