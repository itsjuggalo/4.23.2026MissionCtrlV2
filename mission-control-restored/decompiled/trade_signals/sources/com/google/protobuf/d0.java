package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class d0 {

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1467f f16359a;

        public a(AbstractC1467f abstractC1467f) {
            this.f16359a = abstractC1467f;
        }

        @Override // com.google.protobuf.d0.b
        public byte a(int i8) {
            return this.f16359a.d(i8);
        }

        @Override // com.google.protobuf.d0.b
        public int size() {
            return this.f16359a.size();
        }
    }

    public interface b {
        byte a(int i8);

        int size();
    }

    public static String a(AbstractC1467f abstractC1467f) {
        return b(new a(abstractC1467f));
    }

    public static String b(b bVar) {
        String str;
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i8 = 0; i8 < bVar.size(); i8++) {
            int iA = bVar.a(i8);
            if (iA == 34) {
                str = "\\\"";
            } else if (iA == 39) {
                str = "\\'";
            } else if (iA != 92) {
                switch (iA) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (iA < 32 || iA > 126) {
                            sb.append('\\');
                            sb.append((char) (((iA >>> 6) & 3) + 48));
                            sb.append((char) (((iA >>> 3) & 7) + 48));
                            iA = (iA & 7) + 48;
                        }
                        sb.append((char) iA);
                        continue;
                        break;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static String c(String str) {
        return a(AbstractC1467f.C(str));
    }
}
