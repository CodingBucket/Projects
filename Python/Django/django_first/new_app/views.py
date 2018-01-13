from django.http import HttpResponse
#from  music.models import Album

from django.core.files.storage import default_storage
from django.core.files.base import ContentFile

import os.path
from django.conf import settings

SITE_ROOT = os.path.dirname(os.path.realpath(__file__))
PROJECT_PATH = os.path.abspath(os.path.dirname(__name__))

def get_data():

    with open('../Repo/email.txt', 'w') as f:
        f.write("I AM NEW FILE")

    print(SITE_ROOT)
    print(PROJECT_PATH)
    #print(settings.BASE_DIR)

    #all_albums = Album.objects.all()
    #return HttpResponse(all_albums)

get_data()