package Z0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Configurator f5768a = new b();

    public static final class a implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5769a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f5770b = FieldDescriptor.of(com.amazon.a.a.o.b.f8735I);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f5771c = FieldDescriptor.of("model");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f5772d = FieldDescriptor.of("hardware");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f5773e = FieldDescriptor.of("device");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f5774f = FieldDescriptor.of("product");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f5775g = FieldDescriptor.of("osBuild");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f5776h = FieldDescriptor.of("manufacturer");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final FieldDescriptor f5777i = FieldDescriptor.of("fingerprint");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final FieldDescriptor f5778j = FieldDescriptor.of("locale");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final FieldDescriptor f5779k = FieldDescriptor.of("country");

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final FieldDescriptor f5780l = FieldDescriptor.of("mccMnc");

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final FieldDescriptor f5781m = FieldDescriptor.of("applicationBuild");

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(Z0.a aVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f5770b, aVar.m());
            objectEncoderContext.add(f5771c, aVar.j());
            objectEncoderContext.add(f5772d, aVar.f());
            objectEncoderContext.add(f5773e, aVar.d());
            objectEncoderContext.add(f5774f, aVar.l());
            objectEncoderContext.add(f5775g, aVar.k());
            objectEncoderContext.add(f5776h, aVar.h());
            objectEncoderContext.add(f5777i, aVar.e());
            objectEncoderContext.add(f5778j, aVar.g());
            objectEncoderContext.add(f5779k, aVar.c());
            objectEncoderContext.add(f5780l, aVar.i());
            objectEncoderContext.add(f5781m, aVar.b());
        }
    }

    /* JADX INFO: renamed from: Z0.b$b, reason: collision with other inner class name */
    public static final class C0081b implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0081b f5782a = new C0081b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f5783b = FieldDescriptor.of("logRequest");

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(n nVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f5783b, nVar.c());
        }
    }

    public static final class c implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5784a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f5785b = FieldDescriptor.of("clientType");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f5786c = FieldDescriptor.of("androidClientInfo");

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(o oVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f5785b, oVar.c());
            objectEncoderContext.add(f5786c, oVar.b());
        }
    }

    public static final class d implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f5787a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f5788b = FieldDescriptor.of("privacyContext");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f5789c = FieldDescriptor.of("productIdOrigin");

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(p pVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f5788b, pVar.b());
            objectEncoderContext.add(f5789c, pVar.c());
        }
    }

    public static final class e implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f5790a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f5791b = FieldDescriptor.of("clearBlob");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f5792c = FieldDescriptor.of("encryptedBlob");

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(q qVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f5791b, qVar.b());
            objectEncoderContext.add(f5792c, qVar.c());
        }
    }

    public static final class f implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f5793a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f5794b = FieldDescriptor.of("originAssociatedProductId");

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(r rVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f5794b, rVar.b());
        }
    }

    public static final class g implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f5795a = new g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f5796b = FieldDescriptor.of("prequest");

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(s sVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f5796b, sVar.b());
        }
    }

    public static final class h implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f5797a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f5798b = FieldDescriptor.of("eventTimeMs");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f5799c = FieldDescriptor.of("eventCode");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f5800d = FieldDescriptor.of("complianceData");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f5801e = FieldDescriptor.of("eventUptimeMs");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f5802f = FieldDescriptor.of("sourceExtension");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f5803g = FieldDescriptor.of("sourceExtensionJsonProto3");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f5804h = FieldDescriptor.of("timezoneOffsetSeconds");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final FieldDescriptor f5805i = FieldDescriptor.of("networkConnectionInfo");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final FieldDescriptor f5806j = FieldDescriptor.of("experimentIds");

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(t tVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f5798b, tVar.d());
            objectEncoderContext.add(f5799c, tVar.c());
            objectEncoderContext.add(f5800d, tVar.b());
            objectEncoderContext.add(f5801e, tVar.e());
            objectEncoderContext.add(f5802f, tVar.h());
            objectEncoderContext.add(f5803g, tVar.i());
            objectEncoderContext.add(f5804h, tVar.j());
            objectEncoderContext.add(f5805i, tVar.g());
            objectEncoderContext.add(f5806j, tVar.f());
        }
    }

    public static final class i implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f5807a = new i();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f5808b = FieldDescriptor.of("requestTimeMs");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f5809c = FieldDescriptor.of("requestUptimeMs");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f5810d = FieldDescriptor.of("clientInfo");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f5811e = FieldDescriptor.of("logSource");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f5812f = FieldDescriptor.of("logSourceName");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f5813g = FieldDescriptor.of("logEvent");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f5814h = FieldDescriptor.of("qosTier");

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(u uVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f5808b, uVar.g());
            objectEncoderContext.add(f5809c, uVar.h());
            objectEncoderContext.add(f5810d, uVar.b());
            objectEncoderContext.add(f5811e, uVar.d());
            objectEncoderContext.add(f5812f, uVar.e());
            objectEncoderContext.add(f5813g, uVar.c());
            objectEncoderContext.add(f5814h, uVar.f());
        }
    }

    public static final class j implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f5815a = new j();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f5816b = FieldDescriptor.of("networkType");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f5817c = FieldDescriptor.of("mobileSubtype");

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(w wVar, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f5816b, wVar.c());
            objectEncoderContext.add(f5817c, wVar.b());
        }
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig encoderConfig) {
        C0081b c0081b = C0081b.f5782a;
        encoderConfig.registerEncoder(n.class, c0081b);
        encoderConfig.registerEncoder(Z0.d.class, c0081b);
        i iVar = i.f5807a;
        encoderConfig.registerEncoder(u.class, iVar);
        encoderConfig.registerEncoder(k.class, iVar);
        c cVar = c.f5784a;
        encoderConfig.registerEncoder(o.class, cVar);
        encoderConfig.registerEncoder(Z0.e.class, cVar);
        a aVar = a.f5769a;
        encoderConfig.registerEncoder(Z0.a.class, aVar);
        encoderConfig.registerEncoder(Z0.c.class, aVar);
        h hVar = h.f5797a;
        encoderConfig.registerEncoder(t.class, hVar);
        encoderConfig.registerEncoder(Z0.j.class, hVar);
        d dVar = d.f5787a;
        encoderConfig.registerEncoder(p.class, dVar);
        encoderConfig.registerEncoder(Z0.f.class, dVar);
        g gVar = g.f5795a;
        encoderConfig.registerEncoder(s.class, gVar);
        encoderConfig.registerEncoder(Z0.i.class, gVar);
        f fVar = f.f5793a;
        encoderConfig.registerEncoder(r.class, fVar);
        encoderConfig.registerEncoder(Z0.h.class, fVar);
        j jVar = j.f5815a;
        encoderConfig.registerEncoder(w.class, jVar);
        encoderConfig.registerEncoder(m.class, jVar);
        e eVar = e.f5790a;
        encoderConfig.registerEncoder(q.class, eVar);
        encoderConfig.registerEncoder(Z0.g.class, eVar);
    }
}
