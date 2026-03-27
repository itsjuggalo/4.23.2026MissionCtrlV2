package I5;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements WildcardType, Type {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f4319c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f4320d = new y(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f4321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f4322b;

    public static final class a {
        public a() {
        }

        public final y a() {
            return y.f4320d;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public y(Type type, Type type2) {
        this.f4321a = type;
        this.f4322b = type2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.f4322b;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        StringBuilder sb;
        Type type;
        if (this.f4322b != null) {
            sb = new StringBuilder();
            sb.append("? super ");
            type = this.f4322b;
        } else {
            Type type2 = this.f4321a;
            if (type2 == null || AbstractC2304t.b(type2, Object.class)) {
                return "?";
            }
            sb = new StringBuilder();
            sb.append("? extends ");
            type = this.f4321a;
        }
        sb.append(x.h(type));
        return sb.toString();
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        Type type = this.f4321a;
        if (type == null) {
            type = Object.class;
        }
        return new Type[]{type};
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    public String toString() {
        return getTypeName();
    }
}
