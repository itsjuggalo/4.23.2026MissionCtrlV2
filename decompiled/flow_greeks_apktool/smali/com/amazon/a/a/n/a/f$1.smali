.class Lcom/amazon/a/a/n/a/f$1;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/a/a/n/a/f;->a(Landroid/app/Activity;Landroid/app/AlertDialog;Lcom/amazon/a/a/n/a/f$a;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/amazon/a/a/n/a/f$a;

.field final synthetic b:Lcom/amazon/a/a/n/a/f;


# direct methods
.method public constructor <init>(Lcom/amazon/a/a/n/a/f;Lcom/amazon/a/a/n/a/f$a;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/amazon/a/a/n/a/f$1;->b:Lcom/amazon/a/a/n/a/f;

    .line 2
    .line 3
    iput-object p2, p0, Lcom/amazon/a/a/n/a/f$1;->a:Lcom/amazon/a/a/n/a/f$a;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
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
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    sget-boolean p1, Lcom/amazon/a/a/o/c;->a:Z

    .line 2
    .line 3
    if-eqz p1, :cond_0

    .line 4
    .line 5
    invoke-static {}, Lcom/amazon/a/a/n/a/f;->m()Lcom/amazon/a/a/o/c;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    const-string p2, "Choice selected!"

    .line 10
    .line 11
    invoke-virtual {p1, p2}, Lcom/amazon/a/a/o/c;->a(Ljava/lang/String;)V

    .line 12
    .line 13
    .line 14
    :cond_0
    iget-object p1, p0, Lcom/amazon/a/a/n/a/f$1;->b:Lcom/amazon/a/a/n/a/f;

    .line 15
    .line 16
    invoke-static {p1}, Lcom/amazon/a/a/n/a/f;->a(Lcom/amazon/a/a/n/a/f;)Z

    .line 17
    .line 18
    .line 19
    move-result p1

    .line 20
    if-eqz p1, :cond_1

    .line 21
    .line 22
    iget-object p1, p0, Lcom/amazon/a/a/n/a/f$1;->b:Lcom/amazon/a/a/n/a/f;

    .line 23
    .line 24
    invoke-static {p1}, Lcom/amazon/a/a/n/a/f;->b(Lcom/amazon/a/a/n/a/f;)Ljava/util/concurrent/BlockingQueue;

    .line 25
    .line 26
    .line 27
    move-result-object p1

    .line 28
    iget-object p2, p0, Lcom/amazon/a/a/n/a/f$1;->a:Lcom/amazon/a/a/n/a/f$a;

    .line 29
    .line 30
    invoke-interface {p1, p2}, Ljava/util/concurrent/BlockingQueue;->add(Ljava/lang/Object;)Z

    .line 31
    .line 32
    .line 33
    :cond_1
    return-void
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method
