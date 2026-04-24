package R5;

import java.util.Collection;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public interface k0 {

    public static final class a implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7252a = new a();

        @Override // R5.k0
        public Collection a(I6.v0 currentTypeConstructor, Collection superTypes, B5.k neighbors, B5.k reportLoop) {
            AbstractC2304t.f(currentTypeConstructor, "currentTypeConstructor");
            AbstractC2304t.f(superTypes, "superTypes");
            AbstractC2304t.f(neighbors, "neighbors");
            AbstractC2304t.f(reportLoop, "reportLoop");
            return superTypes;
        }
    }

    Collection a(I6.v0 v0Var, Collection collection, B5.k kVar, B5.k kVar2);
}
