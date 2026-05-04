.class public final Lrb/g0$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrb/g0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "b"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrb/g0$b$a;
    }
.end annotation


# instance fields
.field public final a:Lrb/k1;

.field public final b:Ljava/lang/Object;

.field public c:Lrb/h;


# direct methods
.method public constructor <init>(Lrb/k1;Ljava/lang/Object;Lrb/h;)V
    .locals 1

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    const-string v0, "status"

    invoke-static {p1, v0}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lrb/k1;

    iput-object p1, p0, Lrb/g0$b;->a:Lrb/k1;

    .line 4
    iput-object p2, p0, Lrb/g0$b;->b:Ljava/lang/Object;

    .line 5
    iput-object p3, p0, Lrb/g0$b;->c:Lrb/h;

    return-void
.end method

.method public synthetic constructor <init>(Lrb/k1;Ljava/lang/Object;Lrb/h;Lrb/g0$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3}, Lrb/g0$b;-><init>(Lrb/k1;Ljava/lang/Object;Lrb/h;)V

    return-void
.end method

.method public static d()Lrb/g0$b$a;
    .locals 2

    .line 1
    new-instance v0, Lrb/g0$b$a;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {v0, v1}, Lrb/g0$b$a;-><init>(Lrb/g0$a;)V

    .line 5
    .line 6
    .line 7
    return-object v0
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method


# virtual methods
.method public a()Ljava/lang/Object;
    .locals 1

    .line 1
    iget-object v0, p0, Lrb/g0$b;->b:Ljava/lang/Object;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public b()Lrb/h;
    .locals 1

    .line 1
    iget-object v0, p0, Lrb/g0$b;->c:Lrb/h;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public c()Lrb/k1;
    .locals 1

    .line 1
    iget-object v0, p0, Lrb/g0$b;->a:Lrb/k1;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method
