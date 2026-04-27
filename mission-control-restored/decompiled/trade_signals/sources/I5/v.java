package I5;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements ParameterizedType, Type {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f4312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f4313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type[] f4314c;

    public /* synthetic */ class a extends AbstractC2302q implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4315a = new a();

        public a() {
            super(1, x.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final String invoke(Type p02) {
            AbstractC2304t.f(p02, "p0");
            return x.h(p02);
        }
    }

    public v(Class rawType, Type type, List typeArguments) {
        AbstractC2304t.f(rawType, "rawType");
        AbstractC2304t.f(typeArguments, "typeArguments");
        this.f4312a = rawType;
        this.f4313b = type;
        this.f4314c = (Type[]) typeArguments.toArray(new Type[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (AbstractC2304t.b(this.f4312a, parameterizedType.getRawType()) && AbstractC2304t.b(this.f4313b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f4314c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f4313b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f4312a;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() throws IOException {
        String strH;
        StringBuilder sb = new StringBuilder();
        Type type = this.f4313b;
        if (type != null) {
            sb.append(x.h(type));
            sb.append("$");
            strH = this.f4312a.getSimpleName();
        } else {
            strH = x.h(this.f4312a);
        }
        sb.append(strH);
        Type[] typeArr = this.f4314c;
        if (!(typeArr.length == 0)) {
            AbstractC2592n.P(typeArr, sb, (50 & 2) != 0 ? ", " : null, (50 & 4) != 0 ? "" : "<", (50 & 8) == 0 ? ">" : "", (50 & 16) != 0 ? -1 : 0, (50 & 32) != 0 ? "..." : null, (50 & 64) != 0 ? null : a.f4315a);
        }
        return sb.toString();
    }

    public int hashCode() {
        int iHashCode = this.f4312a.hashCode();
        Type type = this.f4313b;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
