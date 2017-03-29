import numpy
import csv
table1 = open('Product.csv', 'rb')
table2 = open('Soldvia.csv', 'rb')
reader1 = csv.DictReader(table1)
reader2 = csv.DictReader(table2)


def main():
    # SELECT COUNT AVG productprice FROM product GROUPBY vendorid
    select(['vendorid'], '*', 'productprice', reader1, 'null', 'null', ['vendorid'])


def select(entity, count, avg, destination, place, where, groupby):
    if count != 'null' or avg != 'null':
        if groupby == 'null' or groupby != entity:
            print('syntax wrong')
        else:
            count_c = {}
            entity_c = {}
            list_index = []
            avg_c = {}
            try:
                for row in destination:
                    if row[place] in where:
                        index = ''
                    entity_list = []
                    for column in entity:
                        index += row[column]
                        entity_list.append(row[column])
                    if index in count_c:
                        count_c[index] += 1
                        avg_c[index] += float(row[avg])
                    else:
                        avg_c.update({index: float(row[avg])})
                        list_index.append(index)
                        count_c.update({index: 1})
                        entity_c.update({index: entity_list})
                    else:
                        pass

                for i in range(len(list_index)):
                    #  print avg_c
                    print (list_index[i], count_c[list_index[i]], avg_c[list_index[i]] / count_c[list_index[i]])
                    # print entity_c[list_index[i]]
                    # print count_c[list_index[i]]
            except Exception as e:
                print(e)
                print("attibute not in row")

    else:
        content = ''
        try:
            for row in destination:
                content += ('\n')
                for column in entity:
                    content += (row[column] + '\t' * 2)
            print content
        except Exception as e:
            print('attrubutes not in row2')


main()
