package a6;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;
import p5.AbstractC2594p;

/* JADX INFO: loaded from: classes2.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O f10015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final O f10016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f10017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2483k f10018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10019e;

    public G(O globalLevel, O o8, Map userDefinedLevelForSpecificAnnotation) {
        AbstractC2304t.f(globalLevel, "globalLevel");
        AbstractC2304t.f(userDefinedLevelForSpecificAnnotation, "userDefinedLevelForSpecificAnnotation");
        this.f10015a = globalLevel;
        this.f10016b = o8;
        this.f10017c = userDefinedLevelForSpecificAnnotation;
        this.f10018d = AbstractC2484l.a(new F(this));
        O o9 = O.f10081c;
        this.f10019e = globalLevel == o9 && o8 == o9 && userDefinedLevelForSpecificAnnotation.isEmpty();
    }

    public static final String[] b(G g8) {
        List listC = AbstractC2594p.c();
        listC.add(g8.f10015a.b());
        O o8 = g8.f10016b;
        if (o8 != null) {
            listC.add("under-migration:" + o8.b());
        }
        for (Map.Entry entry : g8.f10017c.entrySet()) {
            listC.add('@' + entry.getKey() + ':' + ((O) entry.getValue()).b());
        }
        return (String[]) AbstractC2594p.a(listC).toArray(new String[0]);
    }

    public final O c() {
        return this.f10015a;
    }

    public final O d() {
        return this.f10016b;
    }

    public final Map e() {
        return this.f10017c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G)) {
            return false;
        }
        G g8 = (G) obj;
        return this.f10015a == g8.f10015a && this.f10016b == g8.f10016b && AbstractC2304t.b(this.f10017c, g8.f10017c);
    }

    public final boolean f() {
        return this.f10019e;
    }

    public int hashCode() {
        int iHashCode = this.f10015a.hashCode() * 31;
        O o8 = this.f10016b;
        return ((iHashCode + (o8 == null ? 0 : o8.hashCode())) * 31) + this.f10017c.hashCode();
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.f10015a + ", migrationLevel=" + this.f10016b + ", userDefinedLevelForSpecificAnnotation=" + this.f10017c + ')';
    }

    public /* synthetic */ G(O o8, O o9, Map map, int i8, AbstractC2296k abstractC2296k) {
        this(o8, (i8 & 2) != 0 ? null : o9, (i8 & 4) != 0 ? p5.M.h() : map);
    }
}
