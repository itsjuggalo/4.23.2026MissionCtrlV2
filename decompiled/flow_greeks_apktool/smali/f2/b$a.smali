.class public final Lf2/b$a;
.super Lkotlin/jvm/internal/v;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lpd/k;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lf2/b;->b(Lng/u0;Ljava/lang/Object;)Lu6/f;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation


# instance fields
.field public final synthetic a:Ly/c$a;

.field public final synthetic b:Lng/u0;


# direct methods
.method public constructor <init>(Ly/c$a;Lng/u0;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lf2/b$a;->a:Ly/c$a;

    .line 2
    .line 3
    iput-object p2, p0, Lf2/b$a;->b:Lng/u0;

    .line 4
    .line 5
    const/4 p1, 0x1

    .line 6
    invoke-direct {p0, p1}, Lkotlin/jvm/internal/v;-><init>(I)V

    .line 7
    .line 8
    .line 9
    return-void
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
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 1
    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p0, p1}, Lf2/b$a;->invoke(Ljava/lang/Throwable;)V

    sget-object p1, Lcd/h0;->a:Lcd/h0;

    return-object p1
.end method

.method public final invoke(Ljava/lang/Throwable;)V
    .locals 1

    if-eqz p1, :cond_1

    .line 2
    instance-of v0, p1, Ljava/util/concurrent/CancellationException;

    if-eqz v0, :cond_0

    .line 3
    iget-object p1, p0, Lf2/b$a;->a:Ly/c$a;

    invoke-virtual {p1}, Ly/c$a;->c()Z

    return-void

    .line 4
    :cond_0
    iget-object v0, p0, Lf2/b$a;->a:Ly/c$a;

    invoke-virtual {v0, p1}, Ly/c$a;->e(Ljava/lang/Throwable;)Z

    return-void

    .line 5
    :cond_1
    iget-object p1, p0, Lf2/b$a;->a:Ly/c$a;

    iget-object v0, p0, Lf2/b$a;->b:Lng/u0;

    invoke-interface {v0}, Lng/u0;->getCompleted()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p1, v0}, Ly/c$a;->b(Ljava/lang/Object;)Z

    return-void
.end method
