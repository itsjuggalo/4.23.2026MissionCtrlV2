package s4;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: s4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1055b extends Z3.v {
    @Override // Z3.v
    public Object f(byte b3, ByteBuffer byteBuffer) {
        int i = 0;
        if (b3 == -127) {
            Long l6 = (Long) e(byteBuffer);
            if (l6 == null) {
                return null;
            }
            int iLongValue = (int) l6.longValue();
            EnumC1068o.f9739b.getClass();
            EnumC1068o[] enumC1068oArrValues = EnumC1068o.values();
            int length = enumC1068oArrValues.length;
            while (i < length) {
                EnumC1068o enumC1068o = enumC1068oArrValues[i];
                if (enumC1068o.f9744a == iLongValue) {
                    return enumC1068o;
                }
                i++;
            }
            return null;
        }
        if (b3 == -126) {
            Long l7 = (Long) e(byteBuffer);
            if (l7 == null) {
                return null;
            }
            int iLongValue2 = (int) l7.longValue();
            EnumC1062i.f9721b.getClass();
            EnumC1062i[] enumC1062iArrValues = EnumC1062i.values();
            int length2 = enumC1062iArrValues.length;
            while (i < length2) {
                EnumC1062i enumC1062i = enumC1062iArrValues[i];
                if (enumC1062i.f9728a == iLongValue2) {
                    return enumC1062i;
                }
                i++;
            }
            return null;
        }
        if (b3 == -125) {
            Long l8 = (Long) e(byteBuffer);
            if (l8 == null) {
                return null;
            }
            int iLongValue3 = (int) l8.longValue();
            EnumC1073u.f9755b.getClass();
            EnumC1073u[] enumC1073uArrValues = EnumC1073u.values();
            int length3 = enumC1073uArrValues.length;
            while (i < length3) {
                EnumC1073u enumC1073u = enumC1073uArrValues[i];
                if (enumC1073u.f9758a == iLongValue3) {
                    return enumC1073u;
                }
                i++;
            }
            return null;
        }
        if (b3 == -124) {
            Long l9 = (Long) e(byteBuffer);
            if (l9 == null) {
                return null;
            }
            int iLongValue4 = (int) l9.longValue();
            M.f9654b.getClass();
            M[] mArrValues = M.values();
            int length4 = mArrValues.length;
            while (i < length4) {
                M m5 = mArrValues[i];
                if (m5.f9662a == iLongValue4) {
                    return m5;
                }
                i++;
            }
            return null;
        }
        if (b3 != -123) {
            return super.f(b3, byteBuffer);
        }
        Long l10 = (Long) e(byteBuffer);
        if (l10 == null) {
            return null;
        }
        int iLongValue5 = (int) l10.longValue();
        EnumC1072t.f9752b.getClass();
        EnumC1072t[] enumC1072tArrValues = EnumC1072t.values();
        int length5 = enumC1072tArrValues.length;
        while (i < length5) {
            EnumC1072t enumC1072t = enumC1072tArrValues[i];
            if (enumC1072t.f9754a == iLongValue5) {
                return enumC1072t;
            }
            i++;
        }
        return null;
    }

    @Override // Z3.v
    public void k(ByteArrayOutputStream stream, Object obj) {
        kotlin.jvm.internal.j.e(stream, "stream");
        if (obj instanceof EnumC1068o) {
            stream.write(129);
            k(stream, Integer.valueOf(((EnumC1068o) obj).f9744a));
            return;
        }
        if (obj instanceof EnumC1062i) {
            stream.write(130);
            k(stream, Integer.valueOf(((EnumC1062i) obj).f9728a));
            return;
        }
        if (obj instanceof EnumC1073u) {
            stream.write(131);
            k(stream, Integer.valueOf(((EnumC1073u) obj).f9758a));
        } else if (obj instanceof M) {
            stream.write(132);
            k(stream, Integer.valueOf(((M) obj).f9662a));
        } else if (!(obj instanceof EnumC1072t)) {
            super.k(stream, obj);
        } else {
            stream.write(133);
            k(stream, Integer.valueOf(((EnumC1072t) obj).f9754a));
        }
    }
}
