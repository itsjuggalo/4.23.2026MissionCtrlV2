.class public Ls9/b$c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ls9/b;->w(Landroid/app/Activity;Lv9/c;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:Lea/a;

.field public final synthetic b:Landroid/app/Activity;

.field public final synthetic c:Ls9/b;


# direct methods
.method public constructor <init>(Ls9/b;Lea/a;Landroid/app/Activity;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ls9/b$c;->c:Ls9/b;

    .line 2
    .line 3
    iput-object p2, p0, Ls9/b$c;->a:Lea/a;

    .line 4
    .line 5
    iput-object p3, p0, Ls9/b$c;->b:Landroid/app/Activity;

    .line 6
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    .line 9
    .line 10
    return-void
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
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .line 1
    iget-object p1, p0, Ls9/b$c;->c:Ls9/b;

    .line 2
    .line 3
    invoke-static {p1}, Ls9/b;->c(Ls9/b;)Lq9/r;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    if-eqz p1, :cond_0

    .line 8
    .line 9
    const-string p1, "Calling callback for click action"

    .line 10
    .line 11
    invoke-static {p1}, Lu9/l;->f(Ljava/lang/String;)V

    .line 12
    .line 13
    .line 14
    iget-object p1, p0, Ls9/b$c;->c:Ls9/b;

    .line 15
    .line 16
    invoke-static {p1}, Ls9/b;->c(Ls9/b;)Lq9/r;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    iget-object v0, p0, Ls9/b$c;->a:Lea/a;

    .line 21
    .line 22
    invoke-interface {p1, v0}, Lq9/r;->b(Lea/a;)Lcom/google/android/gms/tasks/Task;

    .line 23
    .line 24
    .line 25
    :cond_0
    iget-object p1, p0, Ls9/b$c;->c:Ls9/b;

    .line 26
    .line 27
    iget-object v0, p0, Ls9/b$c;->b:Landroid/app/Activity;

    .line 28
    .line 29
    iget-object v1, p0, Ls9/b$c;->a:Lea/a;

    .line 30
    .line 31
    invoke-virtual {v1}, Lea/a;->b()Ljava/lang/String;

    .line 32
    .line 33
    .line 34
    move-result-object v1

    .line 35
    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    .line 36
    .line 37
    .line 38
    move-result-object v1

    .line 39
    invoke-static {p1, v0, v1}, Ls9/b;->i(Ls9/b;Landroid/app/Activity;Landroid/net/Uri;)V

    .line 40
    .line 41
    .line 42
    iget-object p1, p0, Ls9/b$c;->c:Ls9/b;

    .line 43
    .line 44
    invoke-static {p1}, Ls9/b;->j(Ls9/b;)V

    .line 45
    .line 46
    .line 47
    iget-object p1, p0, Ls9/b$c;->c:Ls9/b;

    .line 48
    .line 49
    iget-object v0, p0, Ls9/b$c;->b:Landroid/app/Activity;

    .line 50
    .line 51
    invoke-static {p1, v0}, Ls9/b;->k(Ls9/b;Landroid/app/Activity;)V

    .line 52
    .line 53
    .line 54
    iget-object p1, p0, Ls9/b$c;->c:Ls9/b;

    .line 55
    .line 56
    invoke-static {p1}, Ls9/b;->l(Ls9/b;)V

    .line 57
    .line 58
    .line 59
    return-void
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
.end method
