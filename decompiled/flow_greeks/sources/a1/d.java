package a1;

import a1.c;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import y0.h;
import z0.a0;
import z0.b0;
import z0.c0;
import z0.d0;
import z0.f;
import z0.g;
import z0.i;
import z0.j;
import z0.l;
import z0.m;
import z0.n;
import z0.o;
import z0.p;
import z0.q;
import z0.r;
import z0.s;
import z0.u;
import z0.v;
import z0.w;
import z0.x;
import z0.y;
import z0.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f12g = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z0.e f13f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final h a(String type, String str) {
            Object objB;
            t.f(type, "type");
            try {
                c.a aVar = c.f11a;
                d dVar = new d(new b0(), null, 2, 0 == true ? 1 : 0);
                if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_ABORT_ERROR")) {
                    objB = aVar.b(new z0.a(), str, dVar);
                } else {
                    if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_CONSTRAINT_ERROR")) {
                        objB = aVar.b(new z0.b(), str, dVar);
                    } else {
                        if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_DATA_CLONE_ERROR")) {
                            objB = aVar.b(new z0.c(), str, dVar);
                        } else {
                            if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_DATA_ERROR")) {
                                objB = aVar.b(new z0.d(), str, dVar);
                            } else {
                                if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_ENCODING_ERROR")) {
                                    objB = aVar.b(new f(), str, dVar);
                                } else {
                                    if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_HIERARCHY_REQUEST_ERROR")) {
                                        objB = aVar.b(new g(), str, dVar);
                                    } else {
                                        if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_IN_USE_ATTRIBUTE_ERROR")) {
                                            objB = aVar.b(new z0.h(), str, dVar);
                                        } else {
                                            if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_INVALID_CHARACTER_ERROR")) {
                                                objB = aVar.b(new i(), str, dVar);
                                            } else {
                                                if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_INVALID_MODIFICATION_ERROR")) {
                                                    objB = aVar.b(new j(), str, dVar);
                                                } else {
                                                    if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_INVALID_NODE_TYPE_ERROR")) {
                                                        objB = aVar.b(new z0.k(), str, dVar);
                                                    } else {
                                                        if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_INVALID_STATE_ERROR")) {
                                                            objB = aVar.b(new l(), str, dVar);
                                                        } else {
                                                            if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_NAMESPACE_ERROR")) {
                                                                objB = aVar.b(new m(), str, dVar);
                                                            } else {
                                                                if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_NETWORK_ERROR")) {
                                                                    objB = aVar.b(new n(), str, dVar);
                                                                } else {
                                                                    if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_NO_MODIFICATION_ALLOWED_ERROR")) {
                                                                        objB = aVar.b(new o(), str, dVar);
                                                                    } else {
                                                                        if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_NOT_ALLOWED_ERROR")) {
                                                                            objB = aVar.b(new p(), str, dVar);
                                                                        } else {
                                                                            if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_NOT_FOUND_ERROR")) {
                                                                                objB = aVar.b(new q(), str, dVar);
                                                                            } else {
                                                                                if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_NOT_READABLE_ERROR")) {
                                                                                    objB = aVar.b(new r(), str, dVar);
                                                                                } else {
                                                                                    if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_NOT_SUPPORTED_ERROR")) {
                                                                                        objB = aVar.b(new s(), str, dVar);
                                                                                    } else {
                                                                                        if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_OPERATION_ERROR")) {
                                                                                            objB = aVar.b(new z0.t(), str, dVar);
                                                                                        } else {
                                                                                            if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_OPT_OUT_ERROR")) {
                                                                                                objB = aVar.b(new u(), str, dVar);
                                                                                            } else {
                                                                                                if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_QUOTA_EXCEEDED_ERROR")) {
                                                                                                    objB = aVar.b(new v(), str, dVar);
                                                                                                } else {
                                                                                                    if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_READ_ONLY_ERROR")) {
                                                                                                        objB = aVar.b(new w(), str, dVar);
                                                                                                    } else {
                                                                                                        if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_SECURITY_ERROR")) {
                                                                                                            objB = aVar.b(new x(), str, dVar);
                                                                                                        } else {
                                                                                                            if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_SYNTAX_ERROR")) {
                                                                                                                objB = aVar.b(new y(), str, dVar);
                                                                                                            } else {
                                                                                                                if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_TIMEOUT_ERROR")) {
                                                                                                                    objB = aVar.b(new z(), str, dVar);
                                                                                                                } else {
                                                                                                                    if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_TRANSACTION_INACTIVE_ERROR")) {
                                                                                                                        objB = aVar.b(new a0(), str, dVar);
                                                                                                                    } else {
                                                                                                                        if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_UNKNOWN_ERROR")) {
                                                                                                                            objB = aVar.b(new b0(), str, dVar);
                                                                                                                        } else {
                                                                                                                            if (t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_VERSION_ERROR")) {
                                                                                                                                objB = aVar.b(new c0(), str, dVar);
                                                                                                                            } else {
                                                                                                                                if (!t.b(type, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/androidx.credentials.TYPE_WRONG_DOCUMENT_ERROR")) {
                                                                                                                                    throw new b1.b();
                                                                                                                                }
                                                                                                                                objB = aVar.b(new d0(), str, dVar);
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return (h) objB;
            } catch (b1.b unused) {
                return new y0.g(type, str);
            }
        }

        public a() {
        }
    }

    public /* synthetic */ d(z0.e eVar, CharSequence charSequence, int i10, k kVar) {
        this(eVar, (i10 & 2) != 0 ? null : charSequence);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(z0.e domError, CharSequence charSequence) {
        super("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + domError.a(), charSequence);
        t.f(domError, "domError");
        this.f13f = domError;
    }
}
