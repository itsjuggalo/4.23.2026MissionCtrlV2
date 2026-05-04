.class public final Ltb/c1$c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ltb/c1$d;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/c1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "c"
.end annotation


# instance fields
.field public final a:Ltb/w;


# direct methods
.method public constructor <init>(Ltb/w;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Ltb/c1$c;->a:Ltb/w;

    .line 5
    .line 6
    return-void
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic c(Ltb/c1$c;)Ltb/w;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/c1$c;->a:Ltb/w;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method


# virtual methods
.method public a()V
    .locals 3

    .line 1
    iget-object v0, p0, Ltb/c1$c;->a:Ltb/w;

    .line 2
    .line 3
    sget-object v1, Lrb/k1;->t:Lrb/k1;

    .line 4
    .line 5
    const-string v2, "Keepalive failed. The connection is likely gone"

    .line 6
    .line 7
    invoke-virtual {v1, v2}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 8
    .line 9
    .line 10
    move-result-object v1

    .line 11
    invoke-interface {v0, v1}, Ltb/k1;->h(Lrb/k1;)V

    .line 12
    .line 13
    .line 14
    return-void
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public b()V
    .locals 3

    .line 1
    iget-object v0, p0, Ltb/c1$c;->a:Ltb/w;

    .line 2
    .line 3
    new-instance v1, Ltb/c1$c$a;

    .line 4
    .line 5
    invoke-direct {v1, p0}, Ltb/c1$c$a;-><init>(Ltb/c1$c;)V

    .line 6
    .line 7
    .line 8
    invoke-static {}, Lu6/g;->a()Ljava/util/concurrent/Executor;

    .line 9
    .line 10
    .line 11
    move-result-object v2

    .line 12
    invoke-interface {v0, v1, v2}, Ltb/t;->b(Ltb/t$a;Ljava/util/concurrent/Executor;)V

    .line 13
    .line 14
    .line 15
    return-void
    .line 16
    .line 17
    .line 18
    .line 19
.end method
