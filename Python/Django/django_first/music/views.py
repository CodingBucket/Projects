from django.shortcuts import render, get_object_or_404
from django.http import HttpResponse
from .models import Album


def index(request):
    all_albums = Album.objects.all()
    return render(request, 'music/index.html', {'all_albums': all_albums})

def detail(request, album_id):
    album = get_object_or_404(Album, pk=album_id)
    return render(request, 'music/detail.html', {'album': album})

def save_data():
    b = Album(artist='Beatles Blog', album_title='All the latest Beatles news.')
    b.save()

def get_data(request):
    all_albums = Album.objects.all()
    return HttpResponse(all_albums)