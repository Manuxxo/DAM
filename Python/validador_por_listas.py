# futuros tókens
verbo = ['dar', 'abrir', 'cerrar', 'coger', 'hablar', 'mirar', 'usar', 'empujar', 'tirar']
verbosdireccion=['ir']
comando = ['inventario', 'nuevo', 'guardar', 'cargar', 'mapa', 'ayuda']
objeto = ['llave', 'cofre', 'candelabro', 'pistola', 'cuchillo', 'pan', 'agua']
personajes = ['mago', 'guerrero', 'doncella', 'tendero']
conjunciones = ['a', 'con']
verbosmercado = ['comprar', 'vender']
ordenes = ['si', 'no']
direccion=['norte', 'sur', 'este', 'oeste']

#reglas grámaticales

procesoverbos=['objeto','personaje','conjuncion','comando']
procesodireccion=['norte','sur','este','oeste']
procesoconjuncion=['personaje','objeto']
procesospersonaje=['conjuncion']
procesosverbosmercado=['objeto']
#procesoobjeto=['conjuncion']
procesopalabrafinal=['personaje','objeto','direccion','ordenes','comando']

procesotokens=[]
procesotokens.append(['dar', 'objeto', 'a', 'personaje'])
procesotokens.append(['abrir', 'objeto', 'con', 'objeto'])
procesotokens.append(['dar' 'objeto'])
procesotokens.append(['cerrar' 'objeto'])
procesotokens.append(['cerrar' 'objeto','con','objeto'])
procesotokens.append(['hablar', 'con', 'personaje'])
procesotokens.append(['mirar','objeto'])
procesotokens.append(['mirar','personaje'])
procesotokens.append(['usar','objeto'])
procesotokens.append(['usar','objeto','con','personaje'])
procesotokens.append(['empujar','objeto'])
procesotokens.append(['empujar','objeto','con','objeto'])
procesotokens.append(['tirar','objeto'])
procesotokens.append(['tirar','objeto','a','personaje'])



def validacionsintaxis(lista):
    for i in lista:
        if i in verbo or i in personajes or i in comando or i in verbosdireccion or i in objeto or i in conjunciones or i in verbosmercado or i in ordenes or i in direccion:
            correcto = True
        else:
            correcto = False
            # mensaje final
            print("Sintaxis NO válida")
            exit()
    # mensaje final
    if correcto:
        print("Sintaxis válida")


def validadcionsemantica(lista):
    token = []
    for i in lista:
        if i in verbo:
            if i == 'dar':
                token.append('dar')
            elif i == 'abrir':
                token.append('abrir')
            elif i == 'cerrar':
                token.append('cerrar')
            elif i == 'hablar':
                token.append('hablar')
            elif i == 'mirar':
                token.append('mirar')
            elif i == 'usar':
                token.append('usar')
            elif i == 'empujar':
                token.append('empujar')
            elif i == 'tirar':
                token.append('tirar')
        elif i in comando:
            token.append('comando')
        elif i in verbosdireccion:
            token.append('verbosdireccion')
        elif i in objeto:
            token.append('objeto')
        elif i in conjunciones:
            if i == 'a':
                token.append('a')
            else:
                token.append('con')
        elif i in verbosmercado:
            token.append('verbosmercado')
        elif i in ordenes:
            token.append('ordenes')
        elif i in direccion:
            token.append('direccion')
        elif i in personajes:
            token.append('personaje')

    #comparo las listas para comprobar si los token son iguales
    for i in procesotokens:
        if token == i:
            return True

    #si no ha hecho el return antes, es que es falso
    return False

def main():
    entrada = input ("Dame la frase a validar: ")
    lista = list(entrada.split(" "))
    validacionsintaxis(lista)
    correcto = validadcionsemantica(lista)
    if correcto:
        print("Semántica válida")
    else:
        print("Semántica NO válida")

main()