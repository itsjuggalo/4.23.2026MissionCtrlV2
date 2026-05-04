.class public Lpa/q;
.super La7/m;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lpa/q$a;
    }
.end annotation


# instance fields
.field public final a:Lpa/q$a;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, La7/m;-><init>(Ljava/lang/String;)V

    .line 2
    sget-object p1, Lpa/q$a;->b:Lpa/q$a;

    iput-object p1, p0, Lpa/q;->a:Lpa/q$a;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0

    .line 3
    invoke-direct {p0, p1, p2}, La7/m;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 4
    sget-object p1, Lpa/q$a;->b:Lpa/q$a;

    iput-object p1, p0, Lpa/q;->a:Lpa/q$a;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;Lpa/q$a;)V
    .locals 0

    .line 7
    invoke-direct {p0, p1, p2}, La7/m;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 8
    iput-object p3, p0, Lpa/q;->a:Lpa/q$a;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lpa/q$a;)V
    .locals 0

    .line 5
    invoke-direct {p0, p1}, La7/m;-><init>(Ljava/lang/String;)V

    .line 6
    iput-object p2, p0, Lpa/q;->a:Lpa/q$a;

    return-void
.end method
