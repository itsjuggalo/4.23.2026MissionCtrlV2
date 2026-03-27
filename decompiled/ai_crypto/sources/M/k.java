package M;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f3719a;

    public k(Object obj) {
        this.f3719a = (LocaleList) obj;
    }

    @Override // M.j
    public String a() {
        return this.f3719a.toLanguageTags();
    }

    @Override // M.j
    public Object b() {
        return this.f3719a;
    }

    public boolean equals(Object obj) {
        return this.f3719a.equals(((j) obj).b());
    }

    @Override // M.j
    public Locale get(int i7) {
        return this.f3719a.get(i7);
    }

    public int hashCode() {
        return this.f3719a.hashCode();
    }

    @Override // M.j
    public boolean isEmpty() {
        return this.f3719a.isEmpty();
    }

    @Override // M.j
    public int size() {
        return this.f3719a.size();
    }

    public String toString() {
        return this.f3719a.toString();
    }
}
