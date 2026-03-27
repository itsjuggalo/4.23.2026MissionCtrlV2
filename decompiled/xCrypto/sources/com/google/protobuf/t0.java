package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class t0 {

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1062i f11168a;

        public a(AbstractC1062i abstractC1062i) {
            this.f11168a = abstractC1062i;
        }

        @Override // com.google.protobuf.t0.b
        public byte a(int i4) {
            return this.f11168a.k(i4);
        }

        @Override // com.google.protobuf.t0.b
        public int size() {
            return this.f11168a.size();
        }
    }

    public interface b {
        byte a(int i4);

        int size();
    }

    public static String a(AbstractC1062i abstractC1062i) {
        return b(new a(abstractC1062i));
    }

    public static String b(b bVar) {
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i4 = 0; i4 < bVar.size(); i4++) {
            byte bA = bVar.a(i4);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String c(String str) {
        return a(AbstractC1062i.r(str));
    }
}
