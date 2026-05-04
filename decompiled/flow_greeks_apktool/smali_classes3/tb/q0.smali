.class public abstract Ltb/q0;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# static fields
.field public static final a:Lrb/a$c;

.field public static final b:Lrb/a$c;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    const-string v0, "io.grpc.internal.GrpcAttributes.securityLevel"

    .line 2
    .line 3
    invoke-static {v0}, Lrb/a$c;->a(Ljava/lang/String;)Lrb/a$c;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    sput-object v0, Ltb/q0;->a:Lrb/a$c;

    .line 8
    .line 9
    const-string v0, "io.grpc.internal.GrpcAttributes.clientEagAttrs"

    .line 10
    .line 11
    invoke-static {v0}, Lrb/a$c;->a(Ljava/lang/String;)Lrb/a$c;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    sput-object v0, Ltb/q0;->b:Lrb/a$c;

    .line 16
    .line 17
    return-void
    .line 18
    .line 19
.end method
