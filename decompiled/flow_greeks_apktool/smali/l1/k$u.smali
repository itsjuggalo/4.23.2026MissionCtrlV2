.class public final Ll1/k$u;
.super Lkotlin/jvm/internal/v;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lpd/k;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ll1/k;-><init>(Ll1/j0;Ljava/util/List;Ll1/e;Lng/n0;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation


# instance fields
.field public final synthetic a:Ll1/k;


# direct methods
.method public constructor <init>(Ll1/k;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ll1/k$u;->a:Ll1/k;

    .line 2
    .line 3
    const/4 p1, 0x1

    .line 4
    invoke-direct {p0, p1}, Lkotlin/jvm/internal/v;-><init>(I)V

    .line 5
    .line 6
    .line 7
    return-void
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
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 1
    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p0, p1}, Ll1/k$u;->invoke(Ljava/lang/Throwable;)V

    sget-object p1, Lcd/h0;->a:Lcd/h0;

    return-object p1
.end method

.method public final invoke(Ljava/lang/Throwable;)V
    .locals 2

    if-eqz p1, :cond_0

    .line 2
    iget-object v0, p0, Ll1/k$u;->a:Ll1/k;

    .line 3
    invoke-static {v0}, Ll1/k;->d(Ll1/k;)Ll1/l;

    move-result-object v0

    new-instance v1, Ll1/r;

    invoke-direct {v1, p1}, Ll1/r;-><init>(Ljava/lang/Throwable;)V

    invoke-virtual {v0, v1}, Ll1/l;->c(Ll1/i0;)Ll1/i0;

    .line 4
    :cond_0
    iget-object p1, p0, Ll1/k$u;->a:Ll1/k;

    invoke-static {p1}, Ll1/k;->g(Ll1/k;)Lcd/k;

    move-result-object p1

    invoke-interface {p1}, Lcd/k;->d()Z

    move-result p1

    if-eqz p1, :cond_1

    .line 5
    iget-object p1, p0, Ll1/k$u;->a:Ll1/k;

    invoke-virtual {p1}, Ll1/k;->s()Ll1/k0;

    move-result-object p1

    invoke-interface {p1}, Ll1/c;->close()V

    :cond_1
    return-void
.end method
