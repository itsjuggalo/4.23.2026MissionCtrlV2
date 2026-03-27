package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public abstract class d0 {

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0793f f6992a;

        public a(AbstractC0793f abstractC0793f) {
            this.f6992a = abstractC0793f;
        }

        @Override // androidx.datastore.preferences.protobuf.d0.b
        public byte a(int i4) {
            return this.f6992a.f(i4);
        }

        @Override // androidx.datastore.preferences.protobuf.d0.b
        public int size() {
            return this.f6992a.size();
        }
    }

    public interface b {
        byte a(int i4);

        int size();
    }

    public static String a(AbstractC0793f abstractC0793f) {
        return b(new a(abstractC0793f));
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
        return a(AbstractC0793f.n(str));
    }
}
