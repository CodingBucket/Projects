from django.conf.urls import url
from . import views

app_name = 'music'

urlpatterns = [
    # /music/
    url(r'^$', views.index, name='index'),

    # /music/123
    url(r'^(?P<album_id>[0-9]+)/$', views.detail, name='detail'),

    url(r'^save_data/', views.save_data, name='save_data'),
    url(r'^get_data', views.get_data, name='get_data'),

    #url(r'^(?P<album_id>[0-9]+)/favorite/$', views.favorite, name='favorite'),
]
