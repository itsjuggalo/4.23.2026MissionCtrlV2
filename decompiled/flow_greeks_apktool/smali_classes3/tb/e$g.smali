.class public Ltb/e$g;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ltb/p2$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/e;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "g"
.end annotation


# instance fields
.field public final a:Ljava/lang/Runnable;

.field public b:Z

.field public final synthetic c:Ltb/e;


# direct methods
.method public constructor <init>(Ltb/e;Ljava/lang/Runnable;)V
    .locals 0

    .line 2
    iput-object p1, p0, Ltb/e$g;->c:Ltb/e;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 p1, 0x0

    .line 3
    iput-boolean p1, p0, Ltb/e$g;->b:Z

    .line 4
    iput-object p2, p0, Ltb/e$g;->a:Ljava/lang/Runnable;

    return-void
.end method

.method public synthetic constructor <init>(Ltb/e;Ljava/lang/Runnable;Ltb/e$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Ltb/e$g;-><init>(Ltb/e;Ljava/lang/Runnable;)V

    return-void
.end method


# virtual methods
.method public final b()V
    .locals 1

    .line 1
    iget-boolean v0, p0, Ltb/e$g;->b:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    iget-object v0, p0, Ltb/e$g;->a:Ljava/lang/Runnable;

    .line 6
    .line 7
    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 8
    .line 9
    .line 10
    const/4 v0, 0x1

    .line 11
    iput-boolean v0, p0, Ltb/e$g;->b:Z

    .line 12
    .line 13
    :cond_0
    return-void
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public next()Ljava/io/InputStream;
    .locals 1

    .line 1
    invoke-virtual {p0}, Ltb/e$g;->b()V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Ltb/e$g;->c:Ltb/e;

    .line 5
    .line 6
    invoke-static {v0}, Ltb/e;->d(Ltb/e;)Ltb/f;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    invoke-virtual {v0}, Ltb/f;->f()Ljava/io/InputStream;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    return-object v0
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method
