from django.conf.urls import url
from . import views

app_name = 'new_app'

urlpatterns = [

    url(r'^get_data', views.get_data, name='get_data'),

]
