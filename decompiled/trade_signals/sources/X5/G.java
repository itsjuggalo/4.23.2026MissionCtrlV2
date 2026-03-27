package X5;

import h6.InterfaceC1889B;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class G extends u implements InterfaceC1889B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f9399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Annotation[] f9400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9402d;

    public G(E type, Annotation[] reflectAnnotations, String str, boolean z7) {
        AbstractC2304t.f(type, "type");
        AbstractC2304t.f(reflectAnnotations, "reflectAnnotations");
        this.f9399a = type;
        this.f9400b = reflectAnnotations;
        this.f9401c = str;
        this.f9402d = z7;
    }

    @Override // h6.InterfaceC1889B
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public E getType() {
        return this.f9399a;
    }

    @Override // h6.InterfaceC1895d
    public C0991g b(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        return k.a(this.f9400b, fqName);
    }

    @Override // h6.InterfaceC1889B
    public q6.f getName() {
        String str = this.f9401c;
        if (str != null) {
            return q6.f.k(str);
        }
        return null;
    }

    @Override // h6.InterfaceC1895d
    public boolean i() {
        return false;
    }

    @Override // h6.InterfaceC1889B
    public boolean j() {
        return this.f9402d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(G.class.getName());
        sb.append(": ");
        sb.append(j() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }

    @Override // h6.InterfaceC1895d
    public List getAnnotations() {
        return k.b(this.f9400b);
    }
}
